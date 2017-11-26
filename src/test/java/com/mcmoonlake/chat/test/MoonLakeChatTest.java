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


package com.mcmoonlake.chat.test;

import com.mcmoonlake.chat.*;
import org.junit.Assert;
import org.junit.Test;

public class MoonLakeChatTest {

    public static void main(String[] args) {
    }

    @Test
    public void testFancy() {
        ChatComponent fancy = new ChatComponentFancy("你好啊 ")
                .color(ChatColor.AQUA)
                .then("Month_Light ")
                .color(ChatColor.GREEN)
                .then("欢迎来到月色之湖服务器! ")
                .color(ChatColor.AQUA)
                .join(
                        new ChatComponentFancy("[")
                                .color(ChatColor.GREEN)
                                .then("官方网站")
                                .color(ChatColor.AQUA)
                                .link("http://www.mcmoonlake.com")
                                .then("]")
                                .color(ChatColor.GREEN)
                                .withBold()
                                .withItalic())
                .build();

        print(fancy);

        Assert.assertEquals("错误: 聊天组件中的内容长度不符合, 应为: 6.", 6, fancy.getExtraSize());
    }

    @Test
    public void testRead() {
        String json = "{\"text\":\"\",\"extra\":[{\"text\":\"文本内容\",\"color\":\"red\"}]}";
        ChatComponent component = ChatSerializer.fromJson(json);
        print(component);
    }

    @Test
    public void testWrite() {
        ChatComponentText root = new ChatComponentText("");
        ChatComponentText text1 = new ChatComponentText("文本内容");
        text1.getStyle().setColor(ChatColor.RED).setBold(true);
        root.append(text1);
        print(root);
    }

    @Test
    public void testEquals() {
        ChatComponentText text1 = new ChatComponentText("比较");
        text1.getStyle().setColor(ChatColor.RED);
        ChatComponentText text2 = new ChatComponentText("比较");
        text2.getStyle().setColor(ChatColor.RED);

        Assert.assertEquals(text1, text2);
    }

    @Test
    public void testItem() {
        ChatComponent fancy = new ChatComponentFancy("[物品展示]")
                .color(ChatColor.AQUA)
                .tooltipItem("{\"id\":\"minecraft:iron_sword\",\"Damage\":0,\"Count\":1,\"tag\":{\"ench\":[{\"id\":16,\"lvl\":5}]}}")
                .build();

        print(fancy);
    }

    @Test
    public void testReadItem() {
        ChatComponent component = ChatSerializer.fromJson("{\"extra\":[{\"color\":\"aqua\",\"hoverEvent\":{\"action\":\"show_item\",\"value\":\"{\\\"id\\\":\\\"minecraft:iron_sword\\\",\\\"Damage\\\":0,\\\"Count\\\":1,\\\"tag\\\":{\\\"ench\\\":[{\\\"id\\\":16,\\\"lvl\\\":5}]}}\"},\"text\":\"[物品展示]\"}],\"text\":\"\"}");
        print(component);
    }

    @Test
    public void testRaw() {
        ChatComponent component = ChatSerializer.fromRaw("§a§nHello§6§nWorld§f!!!");
        print(component);
    }

    public void print(ChatComponent component) {
        System.out.println("结果: " + component.toString());
        System.out.println("结果 Json: " + component.toJson());
        System.out.println("结果 Raw: " + component.toRaw());
    }
}
