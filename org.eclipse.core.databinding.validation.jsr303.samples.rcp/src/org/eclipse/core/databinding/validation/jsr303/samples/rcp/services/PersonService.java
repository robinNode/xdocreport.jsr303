/*******************************************************************************
 * Copyright (c) 2011 Angelo Zerr and Pascal Leclercq.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:      
 *     Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 *     Pascal Leclercq <pascal.leclercq@gmail.com> - Initial API and implementation 
 *******************************************************************************/
package org.eclipse.core.databinding.validation.jsr303.samples.rcp.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.validation.jsr303.samples.rcp.model.Person;

public class PersonService implements IPersonService {

	private static final IPersonService INSTANCE = new PersonService();
	private Map<Long, Person> persons = new HashMap<Long, Person>();

	public PersonService() {
		for (int i = 0; i < 10; i++) {
			Person person = new Person();
			person.setId(i);
			person.setName("Name" + i);
			this.savePerson(person);
		}
	}

	public static IPersonService getInstance() {
		return INSTANCE;
	}

	public Person getPerson(long id) {
		Person person = persons.get(id);
		if (person == null) {
			return null;
		}
		// Emulate Person instance
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setId(person.getId());
		return newPerson;
	}

	public Person savePerson(Person person) {
		// Emulate Person instance
		Person newPerson = new Person();
		newPerson.setName(person.getName());
		newPerson.setId(person.getId());
		persons.put(newPerson.getId(), newPerson);
		return newPerson;
	}

	public Collection<Person> getPersons() {
		return Collections.unmodifiableCollection(persons.values());
	}
}
