package br.com.elo7.sonda.candidato.service;

import java.util.List;
import br.com.elo7.sonda.candidato.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.elo7.sonda.candidato.persistence.Planets;
import br.com.elo7.sonda.candidato.persistence.Probes;

@Service
public class ProbeService {
	@Autowired
	private Planets planets;
	@Autowired
	private Probes probes;

	public List<Probe> landProbes(LandProbes landProbes) {
		Planet planet = landProbes.planet();
		planets.save(planet);

		landProbes.probes().stream()
					.forEach(probe -> probe.getCommands()
							.stream()
							.forEach(command -> {
								command.execute(probe);
								probes.save(probe);
							}));
		
		return landProbes.probes();
	}
}
