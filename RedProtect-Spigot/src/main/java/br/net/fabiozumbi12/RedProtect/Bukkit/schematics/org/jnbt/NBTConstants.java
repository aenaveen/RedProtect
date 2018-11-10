/*
 Copyright @FabioZumbi12

 This class is provided 'as-is', without any express or implied warranty. In no event will the authors be held liable for any
  damages arising from the use of this software.

 Permission is granted to anyone to use this class for any purpose, including commercial plugins, and to alter it and
 redistribute it freely, subject to the following restrictions:
 1 - The origin of this class must not be misrepresented; you must not claim that you wrote the original software. If you
 use this class in other plugins, an acknowledgment in the plugin documentation would be appreciated but is not required.
 2 - Altered source versions must be plainly marked as such, and must not be misrepresented as being the original class.
 3 - This notice may not be removed or altered from any source distribution.

 Este software é fornecido "como está", sem qualquer garantia expressa ou implícita. Em nenhum caso os autores serão
 responsabilizados por quaisquer danos decorrentes do uso deste software.

 É concedida permissão a qualquer pessoa para usar esta classe para qualquer finalidade, incluindo plugins pagos, e para
 alterá-lo e redistribuí-lo livremente, sujeito às seguintes restrições:
 1 - A origem desta classe não deve ser deturpada; você não deve afirmar que escreveu a classe original. Se você usar esta
  classe em um plugin, uma confirmação de autoria na documentação do plugin será apreciada, mas não é necessária.
 2 - Versões de origem alteradas devem ser claramente marcadas como tal e não devem ser deturpadas como sendo a
 classe original.
 3 - Este aviso não pode ser removido ou alterado de qualquer distribuição de origem.
 */

/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package br.net.fabiozumbi12.RedProtect.Bukkit.schematics.org.jnbt;

import java.nio.charset.Charset;

/**
 * A class which holds constant values.
 */
public final class NBTConstants {

    public static final Charset CHARSET = Charset.forName("UTF-8");

    public static final int TYPE_END = 0, TYPE_BYTE = 1, TYPE_SHORT = 2,
            TYPE_INT = 3, TYPE_LONG = 4, TYPE_FLOAT = 5, TYPE_DOUBLE = 6,
            TYPE_BYTE_ARRAY = 7, TYPE_STRING = 8, TYPE_LIST = 9,
            TYPE_COMPOUND = 10, TYPE_INT_ARRAY = 11;

    /**
     * Default private constructor.
     */
    private NBTConstants() {

    }

    /**
     * Convert a type ID to its corresponding {@link Tag} class.
     *
     * @param id type ID
     * @return tag class
     * @throws IllegalArgumentException thrown if the tag ID is not valid
     */
    public static Class<? extends Tag> getClassFromType(int id) {
        switch (id) {
            case TYPE_END:
                return EndTag.class;
            case TYPE_BYTE:
                return ByteTag.class;
            case TYPE_SHORT:
                return ShortTag.class;
            case TYPE_INT:
                return IntTag.class;
            case TYPE_LONG:
                return LongTag.class;
            case TYPE_FLOAT:
                return FloatTag.class;
            case TYPE_DOUBLE:
                return DoubleTag.class;
            case TYPE_BYTE_ARRAY:
                return ByteArrayTag.class;
            case TYPE_STRING:
                return StringTag.class;
            case TYPE_LIST:
                return ListTag.class;
            case TYPE_COMPOUND:
                return CompoundTag.class;
            case TYPE_INT_ARRAY:
                return IntArrayTag.class;
            default:
                throw new IllegalArgumentException("Unknown tag type ID of " + id);
        }
    }

}
