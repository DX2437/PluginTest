package org.zapto.dx2437.plugin_test;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.zapto.dx2437.ci.ci;
import org.zapto.dx2437.cmd.cmd;
import org.zapto.dx2437.event.Event;
import org.zapto.dx2437.s.s;
import org.zapto.dx2437.se.se;
import org.zapto.dx2437.speed.speed;
import org.zapto.dx2437.train.tra;
import org.zapto.dx2437.train.tr;


public class plugin_test extends JavaPlugin implements Listener{
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        this.getCommand("cmd").setExecutor(new cmd());
        this.getCommand("ci").setExecutor(new ci());
        this.getCommand("speed").setExecutor(new speed());
        this.getCommand("se").setExecutor(new se());
        this.getCommand("s").setExecutor(new s());
        this.getCommand("tra").setExecutor(new tra());
        this.getCommand("tr").setExecutor(new tr());
        Bukkit.getServer().getPluginManager().registerEvents(new Event(), this);
    }
}

