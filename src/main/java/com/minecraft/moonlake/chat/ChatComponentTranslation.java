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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatComponentTranslation extends ChatComponentBase {

    private String key;
    private List<Object> withs;

    public ChatComponentTranslation() {
    }

    public ChatComponentTranslation(String key) {
        this.key = key;
        this.withs = new ArrayList<>();
    }

    public ChatComponentTranslation addWiths(Object... with) {
        withs.addAll(Arrays.asList(with));
        return this;
    }

    public String getKey() {
        return key;
    }

    public ChatComponentTranslation setKey(String key) {
        this.key = key;
        return this;
    }

    public List<Object> getWiths() {
        return withs;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof ChatComponentTranslation) {
            ChatComponentTranslation other = (ChatComponentTranslation) obj;
            return super.equals(obj) && key != null ? key.equals(other.key) : other.key == null && withs.equals(other.withs);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (withs != null ? withs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatComponentTranslation{" +
                "key='" + key + '\'' +
                ", withs=" + withs +
                ", style=" + getStyle() +
                ", extras=" + getExtras() +
                '}';
    }
}
