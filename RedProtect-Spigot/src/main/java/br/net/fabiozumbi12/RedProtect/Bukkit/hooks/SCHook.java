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

package br.net.fabiozumbi12.RedProtect.Bukkit.hooks;

import br.net.fabiozumbi12.RedProtect.Bukkit.RedProtect;
import br.net.fabiozumbi12.RedProtect.Bukkit.Region;
import br.net.fabiozumbi12.RedProtect.Bukkit.config.RPConfig;
import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import org.bukkit.entity.Player;

public class SCHook {
    public static boolean getPlayerClan(Region r, Player p) {
        ClanPlayer clan = RedProtect.get().clanManager.getClanPlayer(p);
        return clan != null && clan.getTag().equalsIgnoreCase(r.getFlagString("clan"));
    }

    @SuppressWarnings("deprecation")
    public static boolean inWar(Region r, Player attack, Player defend) {
        if (!RPConfig.getBool("hooks.simpleclans.use-war")) {
            return false;
        }
        if (!RPConfig.getBool("hooks.simpleclans.war-on-server-regions") && r.getLeaders().contains(RPConfig.getString("region-settings.default-leader"))) {
            return false;
        }
        ClanPlayer atClan = RedProtect.get().clanManager.getClanPlayer(attack);
        if (atClan == null) {
            return false;
        }
        ClanPlayer defCclan = RedProtect.get().clanManager.getClanPlayer(defend);
        return defCclan != null && atClan.getClan().isWarring(defCclan.getClan());
    }
}
