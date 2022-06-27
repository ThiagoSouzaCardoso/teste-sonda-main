package br.com.elo7.sonda.candidato.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.elo7.sonda.candidato.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProbeServiceTest {
	
	@Autowired
	private ProbeService subject;
	
	@Test
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {

		Planet planet = new Planet();
		Probe probe = new Probe();
		probe.setDirection(Direction.N);

		probe.setCommands(List.of(Command.L));
		probe.setPlanet(planet);



		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
		Probe probe = new Probe();
		probe.setDirection(Direction.W);

		probe.setCommands(List.of(Command.L));

		Planet planet = new Planet();
		probe.setPlanet(planet);

		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
		Probe probe = new Probe();
		probe.setDirection(Direction.S);

		probe.setCommands(List.of(Command.L));

		Planet planet = new Planet();
		probe.setPlanet(planet);

		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.E, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
		Probe probe = new Probe();
		probe.setDirection(Direction.E);
		probe.setCommands(List.of(Command.L));

		Planet planet = new Planet();
		probe.setPlanet(planet);

		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.N, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
		Probe probe = new Probe();
		probe.setDirection(Direction.N);
		probe.setCommands(List.of(Command.R));

		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.E, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
		Probe probe = new Probe();
		probe.setDirection(Direction.E);
		probe.setCommands(List.of(Command.R));
		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {

		Planet planet = new Planet();
		Probe probe = new Probe();
		probe.setDirection(Direction.S);
		probe.setCommands(List.of(Command.R));
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
		Probe probe = new Probe();
		probe.setDirection(Direction.W);
		probe.setCommands(List.of(Command.R));
		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(Direction.N, probe.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
		Probe probe = new Probe();
		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.N);
		probe.setCommands(List.of(Command.M));

		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(2, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals(Direction.N, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
		Probe probe = new Probe();
		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.S);

		probe.setCommands(List.of(Command.M));

		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);

		assertEquals(0, probe.getY());
		assertEquals(1, probe.getX());
		assertEquals(Direction.S, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
		Probe probe = new Probe();
		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.W);

		probe.setCommands(List.of(Command.M));

		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);
		assertEquals(0, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals(Direction.W, probe.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
		Probe probe = new Probe();
		probe.setX(1);
		probe.setY(1);
		probe.setDirection(Direction.E);

		probe.setCommands(List.of(Command.M));

		Planet planet = new Planet();
		probe.setPlanet(planet);
		LandProbes landProbes = new LandProbes(planet, List.of(probe));

		subject.landProbes(landProbes);

		assertEquals(2, probe.getX());
		assertEquals(1, probe.getY());
		assertEquals(Direction.E, probe.getDirection());
	}
}
