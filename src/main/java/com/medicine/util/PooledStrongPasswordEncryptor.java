package com.medicine.util;

import org.jasypt.digest.PooledStringDigester;

/*
 * =============================================================================
 *
 *   Copyright (c) 2007-2010, The JASYPT team (http://www.jasypt.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */

public final class PooledStrongPasswordEncryptor {

	private static PooledStrongPasswordEncryptor passwordEncryptor = new PooledStrongPasswordEncryptor(
			50);

	public static PooledStrongPasswordEncryptor getInstance() {
		return passwordEncryptor;
	}

	public static void main(String[] args) {
		System.out.println(PooledStrongPasswordEncryptor.getInstance().encryptPassword("admin"));
		System.out.println(PooledStrongPasswordEncryptor.getInstance().checkPassword("admin", "GbsQn5h0rFzdS3bqGzpfEy/arZRQJ2TbOCDurP5IWecXJ0PnfLM5qnYrHaTq4Hlg"));
	}

	private final PooledStringDigester digester;

	public PooledStrongPasswordEncryptor(int poolSize) {
		this.digester = new PooledStringDigester();
		this.digester.setPoolSize(poolSize);
		this.digester.setAlgorithm("SHA-256");
		this.digester.setIterations(100000);
		this.digester.setSaltSizeBytes(16);
		this.digester.initialize();
	}

	public String encryptPassword(final String password) {
		return this.digester.digest(password);
	}

	public boolean checkPassword(final String plainPassword,
			final String encryptedPassword) {
		return this.digester.matches(plainPassword, encryptedPassword);
	}

}
