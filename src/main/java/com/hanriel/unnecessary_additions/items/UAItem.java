package com.hanriel.unnecessary_additions.items;

import com.hanriel.unnecessary_additions.inits.InitCommon;
import net.minecraft.item.Item;

public class UAItem extends Item {
    public UAItem() {
        super(new Item.Properties()
                .group(InitCommon.creativeTab)
        );
    }
}
