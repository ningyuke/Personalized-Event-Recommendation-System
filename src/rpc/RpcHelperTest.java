package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;

public class RpcHelperTest {

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		Item.ItemBuilder builder = new Item.ItemBuilder();
        builder.setItemId("one");
        builder.setRating(5);
        builder.setCategories(category);
        Item one = builder.build();

        builder = new Item.ItemBuilder();
        builder.setItemId("two");
        builder.setRating(5);
        builder.setCategories(category);
        Item two = builder.build();
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one);
		listItem.add(two);
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());
		
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}
