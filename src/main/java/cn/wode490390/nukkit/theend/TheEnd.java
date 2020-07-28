package cn.wode490390.nukkit.theend;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.wode490390.nukkit.theend.generator.TheEndGenerator;
import cn.wode490390.nukkit.theend.listener.PortalListener;
import cn.wode490390.nukkit.theend.listener.TheEndListener;

public class TheEnd extends PluginBase {

    private static TheEnd INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        Config config = this.getConfig();

        TheEndGenerator.setConfig(config);
        Generator.addGenerator(TheEndGenerator.class, "the_end", TheEndGenerator.TYPE_THE_END);

        this.getServer().getPluginManager().registerEvents(new TheEndListener(), this);
        if (config.getBoolean("enable-end-portal", true)) {
            this.getServer().getPluginManager().registerEvents(new PortalListener(), this);
        }
    }

    public static TheEnd getInstance() {
        return INSTANCE;
    }
}
