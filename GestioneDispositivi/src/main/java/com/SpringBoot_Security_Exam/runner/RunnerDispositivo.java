package com.SpringBoot_Security_Exam.runner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.SpringBoot_Security_Exam.entity.Dispositivo;
import com.SpringBoot_Security_Exam.entity.Laptop;
import com.SpringBoot_Security_Exam.entity.Smartphone;
import com.SpringBoot_Security_Exam.entity.StatoDispositivo;
import com.SpringBoot_Security_Exam.entity.Tablet;
import com.SpringBoot_Security_Exam.service.DispositivoService;
import com.SpringBoot_Security_Exam.service.UserService;

@Component
public class RunnerDispositivo implements ApplicationRunner {
	
	@Autowired DispositivoService dispService;
	@Autowired UserService userService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("RunnerDispositivo is running...");
//		popolaDatabaseDispositivi();
	}
	
	public List<Dispositivo> popolaDatabaseDispositivi(){
		List<Dispositivo> list = new ArrayList<>();
		for(int i = 0; i<3; i++) {
		Tablet t = new Tablet(StatoDispositivo.DISPONIBILE);
		dispService.saveDispositivo(t);
		Smartphone s = new Smartphone(StatoDispositivo.DISPONIBILE);
		dispService.saveDispositivo(s);
		Laptop l = new Laptop(StatoDispositivo.DISPONIBILE);
		dispService.saveDispositivo(l);
		list.add(t);
		list.add(s);
		list.add(l);
		}

		return list;
	}
}
