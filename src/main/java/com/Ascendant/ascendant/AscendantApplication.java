package com.Ascendant.ascendant;

import com.Ascendant.ascendant.repository.CaseRepository;
import com.Ascendant.ascendant.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class AscendantApplication {


	// think of this like your entity manager
//	@Autowired
//	private ClientRepository userEntityRepository;
//	@Autowired
//	private CaseRepository caseEntityRepository;
	public static void main(String[] args) {
		SpringApplication.run(AscendantApplication.class, args);
	}

}
