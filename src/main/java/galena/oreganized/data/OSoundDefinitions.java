package galena.oreganized.data;

import galena.oreganized.Oreganized;
import galena.oreganized.index.OSoundEvents;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class OSoundDefinitions extends SoundDefinitionsProvider {

    public OSoundDefinitions(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Oreganized.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(OSoundEvents.SHRAPNEL_BOMB_PRIMED, definition().with(
                sound("minecraft:random/fuse")
        ).subtitle("subtitles.entity.shrapnel_bomb.primed"));
    }
}