package br.com.elo7.sonda.candidato.model;

import java.util.List;

public class Probe {
	private int id;
	private int x;
	private int y;
	private Direction direction;
	private Planet planet;
	private List<Command> commands;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public List<Command> getCommands(){return commands;}

	public void setCommands(List<Command> commands){this.commands=commands;}

	public void moveProbeForward() {
		getDirection().moveProbeForward(this);
	}

	public void turnProbeLeft() {
		setDirection(getDirection().turnProbeLeft());
	}

	public void turnProbeRight() {
		System.out.println(getDirection().turnProbeRight());
		setDirection(getDirection().turnProbeRight());
	}

}
