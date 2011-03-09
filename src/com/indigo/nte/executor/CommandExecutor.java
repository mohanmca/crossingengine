package com.indigo.nte.executor;

import java.util.concurrent.TimeUnit;

public enum CommandExecutor {
	INSTANCE;
	public void executeFor(int time, TimeUnit unit, Command cmd) {
		long initalTime = System.currentTimeMillis();
		long inMillis = unit.toMillis(time);
		while ((System.currentTimeMillis() - initalTime) < inMillis) {
			cmd.execute();
		}
	}

	public static void main(String... args) {
		Command testCommand = new Command() {
			@Override
			public void execute() {
				System.out.println(System.currentTimeMillis());
			}
		};
		
		CommandExecutor.INSTANCE.executeFor(1, TimeUnit.MILLISECONDS, testCommand);
	}
}
