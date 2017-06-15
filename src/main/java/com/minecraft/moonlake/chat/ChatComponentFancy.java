/*
 * Copyright (C) 2017 The MoonLake Authors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


package com.minecraft.moonlake.chat;

import com.minecraft.moonlake.validate.Validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChatComponentFancy {

    private List<ChatComponent> extras;

    public ChatComponentFancy(String text) {
        this.extras = new ArrayList<>();
        this.then(text);
    }

    public ChatComponentFancy then(String text) {
        Validate.notNull(text, "The text object is null.");
        return then(new ChatComponentText(text));
    }

    public ChatComponentFancy then(ChatComponent component) {
        Validate.notNull(component, "The component object is null.");
        extras.add(component);
        return this;
    }

    public ChatComponentFancy color(ChatColor color) {
        Validate.notNull(color, "The chat color object is null.");
        getLast().getStyle().setColor(color);
        return this;
    }

    public ChatComponentFancy file(String path) {
        Validate.notNull(path, "The path object is null.");
        getLast().getStyle().setClickEvent(new ChatClickEvent(ChatClickEvent.Action.OPEN_FILE, path));
        return this;
    }

    public ChatComponentFancy link(String url) {
        Validate.notNull(url, "The url object is null.");
        getLast().getStyle().setClickEvent(new ChatClickEvent(ChatClickEvent.Action.OPEN_URL, url));
        return this;
    }

    public ChatComponentFancy suggest(String command) {
        Validate.notNull(command, "The command object is null.");
        getLast().getStyle().setClickEvent(new ChatClickEvent(ChatClickEvent.Action.SUGGEST_COMMAND, command));
        return this;
    }

    public ChatComponentFancy command(String command) {
        Validate.notNull(command, "The command object is null.");
        getLast().getStyle().setClickEvent(new ChatClickEvent(ChatClickEvent.Action.RUN_COMMAND, command));
        return this;
    }

    public ChatComponentFancy insert(String insertion) {
        Validate.notNull(insertion, "The insertion object is null.");
        getLast().getStyle().setInsertion(insertion);
        return this;
    }

    public ChatComponentFancy tooltipText(String text) {
        Validate.notNull(text, "The text object is null.");
        getLast().getStyle().setHoverEvent(new ChatHoverEvent(ChatHoverEvent.Action.SHOW_TEXT, new ChatComponentText(text)));
        return this;
    }

    public ChatComponentFancy tooltipTexts(String... texts) {
        Validate.notNull(texts, "The texts object is null.");
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < texts.length; i++) {
            builder.append(texts[i]);
            if(i != texts.length - 1)
                builder.append('\n');
        }
        return tooltipText(builder.toString());
    }

    public ChatComponentFancy tooltipTexts(Collection<? extends String> collection) {
        Validate.notNull(collection, "The collection object is null.");
        return tooltipTexts(collection.toArray(new String[collection.size()]));
    }

    public ChatComponentFancy tooltipItem(String item) {
        Validate.notNull(item, "The item object is null.");
        getLast().getStyle().setHoverEvent(new ChatHoverEvent(ChatHoverEvent.Action.SHOW_ITEM, new ChatComponentText(item)));
        return this;
    }

    public ChatComponentFancy join(ChatComponentFancy componentFancy) {
        Validate.notNull(componentFancy, "The component fancy object is null.");
        extras.addAll(componentFancy.extras);
        return this;
    }

    public ChatComponent build() {
        ChatComponent component = new ChatComponentText("");
        component.getExtras().addAll(extras);
        return component;
    }

    protected ChatComponent getLast() {
        return extras.get(extras.size() - 1);
    }
}
