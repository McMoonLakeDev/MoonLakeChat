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

public class ChatStyle {

    private ChatStyle parent;
    ChatColor color;
    Boolean bold;
    Boolean italic;
    Boolean underlined;
    Boolean strikethrough;
    Boolean obfuscated;
    ChatClickEvent clickEvent;
    ChatHoverEvent hoverEvent;
    String insertion;

    private final static ChatStyle ROOT = new ChatStyle() {
        @Override
        public ChatColor getColor() {
            return null;
        }

        @Override
        public boolean getBold() {
            return false;
        }

        @Override
        public boolean getItalic() {
            return false;
        }

        @Override
        public boolean getStrikethrough() {
            return false;
        }

        @Override
        public boolean getUnderlined() {
            return false;
        }

        @Override
        public boolean getObfuscated() {
            return false;
        }

        @Override
        public ChatClickEvent getClickEvent() {
            return null;
        }

        @Override
        public ChatHoverEvent getHoverEvent() {
            return null;
        }

        @Override
        public String getInsertion() {
            return null;
        }

        @Override
        public ChatStyle setColor(ChatColor color) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setBold(Boolean bold) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setItalic(Boolean italic) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setStrikethrough(Boolean strikethrough) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setUnderlined(Boolean underlined) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setObfuscated(Boolean obfuscated) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setClickEvent(ChatClickEvent clickEvent) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setHoverEvent(ChatHoverEvent hoverEvent) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setInsertion(String insertion) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ChatStyle setParent(ChatStyle parent) {
            throw new UnsupportedOperationException();
        }

        @Override
        public String toString() {
            return "ChatStyle.ROOT";
        }
    };

    public ChatColor getColor() {
        return color != null ? color : getParent().getColor();
    }

    public boolean getBold() {
        return bold != null ? bold : getParent().getBold();
    }

    public boolean getItalic() {
        return italic != null ? italic : getParent().getItalic();
    }

    public boolean getStrikethrough() {
        return strikethrough != null ? strikethrough : getParent().getStrikethrough();
    }

    public boolean getUnderlined() {
        return underlined != null ? underlined : getParent().getUnderlined();
    }

    public boolean getObfuscated() {
        return obfuscated != null ? obfuscated : getParent().getObfuscated();
    }

    public ChatClickEvent getClickEvent() {
        return clickEvent != null ? clickEvent : getParent().getClickEvent();
    }

    public ChatHoverEvent getHoverEvent() {
        return hoverEvent != null ? hoverEvent : getParent().getHoverEvent();
    }

    public String getInsertion() {
        return insertion != null ? insertion : getParent().getInsertion();
    }

    public ChatStyle setColor(ChatColor color) {
        this.color = color;
        return this;
    }

    public ChatStyle setBold(Boolean bold) {
        this.bold = bold;
        return this;
    }

    public ChatStyle setItalic(Boolean italic) {
        this.italic = italic;
        return this;
    }

    public ChatStyle setStrikethrough(Boolean strikethrough) {
        this.strikethrough = strikethrough;
        return this;
    }

    public ChatStyle setUnderlined(Boolean underlined) {
        this.underlined = underlined;
        return this;
    }

    public ChatStyle setObfuscated(Boolean obfuscated) {
        this.obfuscated = obfuscated;
        return this;
    }

    public ChatStyle setClickEvent(ChatClickEvent clickEvent) {
        this.clickEvent = clickEvent;
        return this;
    }

    public ChatStyle setHoverEvent(ChatHoverEvent hoverEvent) {
        this.hoverEvent = hoverEvent;
        return this;
    }

    public ChatStyle setInsertion(String insertion) {
        this.insertion = insertion;
        return this;
    }

    public ChatStyle setParent(ChatStyle parent) {
        this.parent = parent;
        return this;
    }

    public boolean isEmpty() {
        return color == null && bold == null && italic == null && strikethrough == null && underlined == null && obfuscated == null && clickEvent == null && hoverEvent == null && insertion == null;
    }

    private ChatStyle getParent() {
        return parent != null ? parent : ROOT;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof ChatStyle) {
            ChatStyle other = (ChatStyle) obj;
            return
                    getColor() == other.getColor() &&
                    getBold() == other.getBold() &&
                    getItalic() == other.getItalic() &&
                    getUnderlined() == other.getUnderlined() &&
                    getStrikethrough() == other.getStrikethrough() &&
                    getObfuscated() == other.getObfuscated() &&
                    getClickEvent() != null ? getClickEvent().equals(other.getClickEvent()) : other.getClickEvent() == null &&
                    getHoverEvent() != null ? getHoverEvent().equals(other.getHoverEvent()) : other.getHoverEvent() == null &&
                    getInsertion() != null ? getInsertion().equals(other.getInsertion()) : other.getInsertion() == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (bold != null ? bold.hashCode() : 0);
        result = 31 * result + (italic != null ? italic.hashCode() : 0);
        result = 31 * result + (underlined != null ? underlined.hashCode() : 0);
        result = 31 * result + (strikethrough != null ? strikethrough.hashCode() : 0);
        result = 31 * result + (obfuscated != null ? obfuscated.hashCode() : 0);
        result = 31 * result + (clickEvent != null ? clickEvent.hashCode() : 0);
        result = 31 * result + (hoverEvent != null ? hoverEvent.hashCode() : 0);
        result = 31 * result + (insertion != null ? insertion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatStyle{" +
                "color=" + color +
                ", bold=" + bold +
                ", italic=" + italic +
                ", underlined=" + underlined +
                ", strikethrough=" + strikethrough +
                ", obfuscated=" + obfuscated +
                ", clickEvent=" + clickEvent +
                ", hoverEvent=" + hoverEvent +
                ", insertion='" + insertion + '\'' +
                '}';
    }
}
