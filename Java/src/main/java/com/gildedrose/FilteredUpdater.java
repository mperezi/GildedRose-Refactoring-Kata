package com.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class FilteredUpdater implements ItemUpdater {

	private List<Filter> filters = new ArrayList<>();

	@Override
	public void update(Item item) {
		filters.stream()
		       .filter(f -> f.filter.test(item))
		       .forEach(f -> f.updater.update(item));
	}

	public FilteredUpdater setFilter(Predicate<Item> filter, ItemUpdater updater) {
		filters.add(new Filter(filter, updater));
		return this;
	}

	public void clearFilters() {
		filters.clear();
	}

	static class Filter {
		Predicate<Item> filter;
		ItemUpdater updater;

		Filter(Predicate<Item> filter, ItemUpdater updater) {
			this.filter = filter;
			this.updater = updater;
		}
	}
}
