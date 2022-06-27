package br.com.elo7.sonda.candidato.controller;

import java.util.List;

import br.com.elo7.sonda.candidato.dto.OutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.elo7.sonda.candidato.dto.InputDTO;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeService probeService;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
    public List<OutputDTO> register(@RequestBody InputDTO inputDto) {

		return OutputDTO.fromDomain(probeService.landProbes(inputDto.toDomain()));
    }
}
