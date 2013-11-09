package net.vl0w.java.itunesapi.main.query;

import net.vl0w.java.itunesapi.main.model.TrackAttribute;

public class ConditionBuilder {

	private StringBuilder condition;

	public ConditionBuilder() {
		condition = new StringBuilder();
	}

	public ConditionBuilder attribute(TrackAttribute attribute) {
		if (!condition.toString().isEmpty()) {
			condition.append(" and ");
		}
		condition.append(attribute.getAttributeIdentifier());
		return this;
	}

	public void is(String value) {
		condition.append(" is \"");
		condition.append(value);
		condition.append("\"");
	}

	public String build() {
		return condition.toString();
	}

}
