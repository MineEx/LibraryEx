/*
 * LibraryEx
 * Copyright (c) 2017-2019 by LogicTechCorp
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package logictechcorp.libraryex.handler;

import logictechcorp.libraryex.LibraryEx;
import logictechcorp.libraryex.world.generation.feature.BiomeDataFeatureWrapper;
import logictechcorp.libraryex.world.generation.feature.OreFeature;
import logictechcorp.libraryex.world.generation.feature.PoolFeature;
import logictechcorp.libraryex.world.generation.feature.TriplePlantFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = LibraryEx.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureRegister
{
    @SubscribeEvent
    public static void onFeatureRegister(RegistryEvent.Register<Feature<?>> event)
    {
        registerFeature("biome_data_feature_wrapper", new BiomeDataFeatureWrapper(BiomeDataFeatureWrapper.Config::deserialize));
        registerFeature("triple_plant", new TriplePlantFeature(TriplePlantFeature.Config::deserialize));
        registerFeature("pool", new PoolFeature(PoolFeature.Config::deserialize));
        registerFeature("ore", new OreFeature(OreFeature.Config::deserialize));
    }

    private static void registerFeature(String name, Feature<?> feature)
    {
        ForgeRegistries.FEATURES.register(feature.setRegistryName(name));
    }
}
