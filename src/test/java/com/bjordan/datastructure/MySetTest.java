package com.bjordan.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MySetTest {
	MySet none = new MySetImpl();
	MySet one = new MySetImpl();
	MySet many = new MySetImpl();

	@Before
	public void setup() {
		one.add("a");

		many.add("a");
		many.add("b");
	}

	@Test
	public void isEmptyWrkz() {
		assertThat(none.isEmpty()).isTrue();
		assertThat(one.isEmpty()).isFalse();
		assertThat(many.isEmpty()).isFalse();
	}

	@Test
	public void countWrkz() {
		assertThat(none.size()).isEqualTo(0);
		assertThat(one.size()).isEqualTo(1);
		assertThat(many.size()).isGreaterThan(1);
	}

	@Test
	public void canNotAddDups() {
		one.add("a");
		assertThat(one.size()).isEqualTo(1);
	}

	@Test
	public void removeWrkz() {
		many.remove("a");
		assertThat(many.size()).isEqualTo(1);
		assertThat(many.contains("b")).isTrue();
		assertThat(many.contains("a")).isFalse();
	}

	@Test
	public void removeNonItemWrkz() {
		one.remove("not in list");
		assertThat(one.size()).isEqualTo(1);
	}

	@Test
	public void canGrow() {
		MySet three = new MySetImpl(2);
		three.add("a");
		three.add("b");
		three.add("c");
	}
}
