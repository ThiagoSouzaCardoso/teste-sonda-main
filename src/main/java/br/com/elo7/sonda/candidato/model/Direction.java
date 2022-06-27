package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.model.Interfaces.MoveFoward;
import br.com.elo7.sonda.candidato.model.Interfaces.TurnLeft;
import br.com.elo7.sonda.candidato.model.Interfaces.TurnRight;

public enum Direction implements TurnLeft, TurnRight, MoveFoward {
	N(){
		@Override
		public Direction turnProbeLeft() {
			return Direction.W;
		}

		@Override
		public Direction turnProbeRight() {
			return Direction.E;
		}

		@Override
		public Probe moveProbeForward(Probe probe) {
			probe.setY(probe.getY()+ 1);
			return probe;
		}
	}

	,W(){
		@Override
		public Direction turnProbeLeft() {
			return Direction.S;
		}

		@Override
		public Direction turnProbeRight() {
			return Direction.N;
		}

		@Override
		public Probe moveProbeForward(Probe probe) {
			probe.setX(probe.getX() -1);
			return probe;
		}
	}
	,E(){
		@Override
		public Direction turnProbeLeft() {
			return Direction.N;
		}

		@Override
		public Direction turnProbeRight() {
			return Direction.S;
		}

		@Override
		public Probe moveProbeForward(Probe probe) {
			probe.setX(probe.getX()+1);
			return probe;
		}
	}
	,S(){
		@Override
		public Direction turnProbeLeft() {
			return Direction.E;
		}

		@Override
		public Direction turnProbeRight() {
			return Direction.W;
		}

		@Override
		public Probe moveProbeForward(Probe probe) {
			probe.setY(probe.getY()-1);
			return probe;
		}
	};

}
