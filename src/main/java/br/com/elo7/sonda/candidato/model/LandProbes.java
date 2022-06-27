package br.com.elo7.sonda.candidato.model;

import java.util.List;

public record LandProbes(
      Planet planet,
      List<Probe> probes
){}
