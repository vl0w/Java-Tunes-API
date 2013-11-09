package net.vl0w.java.itunesapi.main.query;

import static org.junit.Assert.assertEquals;
import net.vl0w.java.itunesapi.main.model.TrackAttribute;

import org.junit.Test;

public class ConditionBuilderTest {
	@Test
	public void testBuildSingleCondition() {
		ConditionBuilder conditionBuilder = new ConditionBuilder();
		conditionBuilder.attribute(TrackAttribute.ID).is("SomeValue");
		assertEquals("id is \"SomeValue\"", conditionBuilder.build());
	}

	@Test
	public void testBuildMultipleConditions() {
		ConditionBuilder conditionBuilder = new ConditionBuilder();
		conditionBuilder.attribute(TrackAttribute.ID).is("1234");
		conditionBuilder.attribute(TrackAttribute.NAME).is("5678");
		assertEquals("id is \"1234\" and name is \"5678\"",
				conditionBuilder.build());
	}
}
