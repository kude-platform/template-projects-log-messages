package de.ddm;

import de.ddm.configuration.Command;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	public static void main(String[] args) {
		Command.applyOn(args);
		new ExcessiveLogger().logExcessively();
	}

}
