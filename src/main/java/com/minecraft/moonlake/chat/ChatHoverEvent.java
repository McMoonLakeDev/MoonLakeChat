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

public class ChatHoverEvent {

    private final Action action;
    private final ChatComponent value;

    public ChatHoverEvent(Action action, ChatComponent value) {
        this.action = action;
        this.value = value;
    }

    public Action getAction() {
        return action;
    }

    public ChatComponent getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof ChatHoverEvent) {
            ChatHoverEvent other = (ChatHoverEvent) obj;
            return action == other.action && value != null ? value.equals(other.value) : other.value == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = action != null ? action.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatHoverEvent{" +
                "action=" + action +
                ", value='" + value + '\'' +
                '}';
    }

    public enum Action {

        SHOW_TEXT,
        SHOW_ACHIEVEMENT,
        SHOW_ITEM,
        SHOW_ENTITY,
        ;

        public static Action fromName(String name) {
            return Action.valueOf(name.toUpperCase());
        }
    }
}
