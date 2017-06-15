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

public class ChatComponentScore extends ChatComponentBase {

    private String name;
    private String objective;
    private String value;

    public ChatComponentScore() {
    }

    public ChatComponentScore(String name, String objective) {
        this.name = name;
        this.objective = objective;
    }

    public String getName() {
        return name;
    }

    public ChatComponentScore setName(String name) {
        this.name = name;
        return this;
    }

    public String getObjective() {
        return objective;
    }

    public ChatComponentScore setObjective(String objective) {
        this.objective = objective;
        return this;
    }

    public String getValue() {
        return value;
    }

    public ChatComponentScore setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof ChatComponentScore) {
            ChatComponentScore other = (ChatComponentScore) obj;
            return super.equals(obj) && name != null ? name.equals(other.name) : other.name == null && objective != null ? objective.equals(other.objective) : other.objective == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (objective != null ? objective.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatComponentScore{" +
                "name='" + name + '\'' +
                ", objective='" + objective + '\'' +
                ", style=" + getStyle() +
                ", extras=" + getExtras() +
                '}';
    }
}
