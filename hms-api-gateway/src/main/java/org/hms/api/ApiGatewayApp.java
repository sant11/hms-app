package org.hms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@Controller
public class ApiGatewayApp 
{
    public static void main( String[] args ) {
        SpringApplication.run(ApiGatewayApp.class, args);
    }
    
    @Bean
    @LoadBalanced
    RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }
    
    
    
    
    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> user(Principal user) {
      Map<String, Object> map = new LinkedHashMap<String, Object>();
      map.put("name", user.getName());
      map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
      return map;
    }    
    
    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

      @Autowired
      public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
  			auth.inMemoryAuthentication()
  				.withUser("user").password("password").roles("USER")
  			.and()
  				.withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
  			.and()
  				.withUser("audit").password("audit").roles("USER", "ADMIN", "READER");
  // @formatter:on
      }

      @Override
      protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
  			http
  				.httpBasic().and()
  				.logout().and()
  				.authorizeRequests().antMatchers("/assets/**").permitAll().and()
  				.authorizeRequests()
  					.antMatchers("/index.html", "/").permitAll()
  					.anyRequest().authenticated()
  					.and()
  				.csrf()
  					.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  			// @formatter:on
      }
    }   
    
    
}
