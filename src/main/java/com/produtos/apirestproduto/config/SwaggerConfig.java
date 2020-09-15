package com.produtos.apirestproduto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import com.google.common.base.Predicate;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket detalheApi() {
 
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.produtos.apirestproduto"))
		.paths(regex("/api.*"))
		.build()
		.apiInfo(this.informacoesApi().build());
 
		return docket;
	}
 
	

	private ApiInfoBuilder informacoesApi() {
 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Api-Produto");
		apiInfoBuilder.description("Api para realização de um CRUD.");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Deve ser usada para estudos.");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("http://www.ciceroednilson.com.br");
		apiInfoBuilder.contact(this.contato()); 
 
		return apiInfoBuilder;
 
	}
	
	private springfox.documentation.service.Contact contato() {
 
		return new springfox.documentation.service.Contact(
				"Gustavo Biasi",
				"https://www.linkedin.com/in/gustavo-biasi-a21847a3/", 
				"gustavobiasi1@hotmail.com");
	}


}
