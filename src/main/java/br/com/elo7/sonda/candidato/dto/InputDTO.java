package br.com.elo7.sonda.candidato.dto;

import br.com.elo7.sonda.candidato.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class InputDTO {
	private int width; 
	private int height;
	private List<ProbeDTO> probes;

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<ProbeDTO> getProbes() {
		return probes;
	}
	public void setProbes(List<ProbeDTO> probes) {
		this.probes = probes;
	}

	public LandProbes toDomain(){
		Planet planet = concertPlanet(this);
		return new LandProbes(planet,convertProbes(this,planet));
	}

	private List<Probe> convertProbes(InputDTO input, Planet planet) {
		return input.getProbes()
				.stream().map(probeDto -> convertProbe(probeDto, planet))
				.collect(Collectors.toList());
	}

	private Planet concertPlanet(InputDTO input) {
		Planet planet = new Planet();
		planet.setHeight(input.getHeight());
		planet.setWidth(input.getWidth());
		return planet;
	}

	private Probe convertProbe(ProbeDTO probeDto, Planet planet) {
		Probe probe = new Probe();
		probe.setPlanet(planet);
		probe.setX(probeDto.getX());
		probe.setY(probeDto.getY());
		probe.setDirection(Direction.valueOf(String.valueOf(probeDto.getDirection())));
		probe.setCommands(convertCommands(probeDto.getCommands()));

		return probe;
	}


	public List<Command> convertCommands(String commands) {
		return commands.chars().mapToObj(i->(char)i).map(
				character -> Command.valueOf(String.valueOf(character))
		).collect(Collectors.toList());
	}


}
