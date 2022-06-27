package br.com.elo7.sonda.candidato.model;

import br.com.elo7.sonda.candidato.model.Interfaces.CommandMove;

public enum Command implements CommandMove {
    L(){
		@Override
		public void execute(Probe probe) {
			probe.turnProbeLeft();
		}
	},
	M(){
		@Override
		public void execute(Probe probe) {
			probe.moveProbeForward();
		}
	},
	R(){
		@Override
		public void execute(Probe probe) {
			probe.turnProbeRight();
		}
	};

}
