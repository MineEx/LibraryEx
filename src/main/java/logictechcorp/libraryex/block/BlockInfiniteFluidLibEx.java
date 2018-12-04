/*
 * LibraryEx
 * Copyright (c) 2017-2018 by MineEx
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

package logictechcorp.libraryex.block;

import com.google.common.base.CaseFormat;
import logictechcorp.libraryex.IModData;
import logictechcorp.libraryex.client.model.item.IModelContainer;
import logictechcorp.libraryex.client.model.item.ItemModelHandler;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockInfiniteFluidLibEx extends BlockFluidClassic implements IModelContainer
{
    private IModData data;

    public BlockInfiniteFluidLibEx(IModData data, String name, Fluid fluid, Material material)
    {
        super(fluid, material);
        this.data = data;
        this.setRegistryName(data.getModId() + ":" + name);
        this.setTranslationKey(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, this.getRegistryName().toString()));
        this.setCreativeTab(data.getCreativeTab());
        data.getModelContainers().add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModel()
    {
        ItemModelHandler.registerModel(this.data, this);
    }
}