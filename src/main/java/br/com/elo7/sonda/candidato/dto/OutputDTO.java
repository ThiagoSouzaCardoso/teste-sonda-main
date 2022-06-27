package br.com.elo7.sonda.candidato.dto;

import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OutputDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("x")
    private int x;
    @JsonProperty("y")
    private int y;
    @JsonProperty("direction")
    private Direction direction;

    @JsonProperty("planet")
    private PlanetOutput planet;

    public OutputDTO(int id, int x, int y, Direction direction, Planet planet) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.planet = PlanetOutput.fromDomain(planet);
    }

    public static List<OutputDTO> fromDomain(List<Probe> landProbes) {
        return landProbes.stream().map(probe ->
            new OutputDTO(probe.getId(),probe.getX(),probe.getY(),probe.getDirection(),probe.getPlanet())
        ).collect(Collectors.toList());
    }
}

@JsonIgnoreProperties(ignoreUnknown=true)
class PlanetOutput{
    @JsonProperty("id")
    private int id;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;

    public PlanetOutput(int id, int width, int height){
        this.id = id;
        this.height = height;
        this.width = width;
    }

    public static PlanetOutput fromDomain(Planet planet){
        return new PlanetOutput(planet.getId(),planet.getWidth(),planet.getHeight());
    }

}
