package com.crater.juanfran.nicemeet.ui.Main.view.Fragments.chat.content;

import com.crater.juanfran.nicemeet.db.model.Conversation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ConversationContent {

    public static final List<Conversation> ITEMS = new ArrayList<Conversation>();


    public static final Map<String, Conversation> ITEM_MAP = new HashMap<String, Conversation>();

    private static void addItem(Conversation item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getUidReciever(), item);
    }

    private static Conversation createConv(int position) {
        return new Conversation();
    }

}
