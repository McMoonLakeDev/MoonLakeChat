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

public class ChatComponentText extends ChatComponentBase {

    private String text;

    public ChatComponentText(String text) {
        this.text = text;
    }

    public ChatComponentText(ChatComponentText text) {
        this.text = text.getText();
    }

    public String getText() {
        return text;
    }

    public ChatComponentText setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof ChatComponentText) {
            ChatComponentText other = (ChatComponentText) obj;
            return super.equals(obj) && text != null ? text.equals(other.text) : other.text == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatComponentText{" +
                "text='" + text + '\'' +
                ", style=" + getStyle() +
                ", extras=" + getExtras() +
                '}';
    }
}
