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

package logictechcorp.libraryex.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper
{
    public static NBTTagCompound setTagCompound(ItemStack stack)
    {
        return setTagCompound(stack, new NBTTagCompound());
    }

    public static NBTTagCompound setTagCompound(ItemStack stack, NBTTagCompound compound)
    {
        if(stack.getTagCompound() == null)
        {
            stack.setTagCompound(compound);
        }
        else if(!compound.isEmpty())
        {
            stack.getTagCompound().merge(compound);
        }

        return stack.getTagCompound();
    }

    public static NBTTagCompound setTagCompound(NBTTagCompound base, String key, NBTTagCompound value)
    {
        if(!base.hasKey(key))
        {
            base.setTag(key, value);
        }

        return base.getCompoundTag(key);
    }
}