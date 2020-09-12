package com.hanriel.unnecessary_additions.items;

import com.hanriel.unnecessary_additions.inits.InitCommon;
import net.minecraft.item.Item;

public class UAOreDust extends Item {
    public UAOreDust() {
        super(new Item.Properties()
                .group(InitCommon.creativeTab)
        );
    }
}
