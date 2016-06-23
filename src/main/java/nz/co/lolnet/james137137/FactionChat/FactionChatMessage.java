/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.lolnet.james137137.FactionChat;

/**
 *
 * @author James
 */
public class FactionChatMessage {

    String format;
    String message;
    boolean allowCostomColour;

    String playerPrefix;
    String playerName;
    String playerSuffix;
    String playerFactionTitle;
    String playerFactionRank;
    String FacitonName;
    String otherFactionName;

    public FactionChatMessage(String format, String message, boolean allowCostomColour, String playerPrefix, String playerName, String playerSuffix, String playerFactionTitle, String playerFactionRank, String FacitonName, String otherFactionName) {
        this.format = checkFormat(format);
        this.message = checkFormat(message);
        this.allowCostomColour = allowCostomColour;
        this.playerPrefix = checkFormat(playerPrefix);
        this.playerName = checkFormat(playerName);
        this.playerSuffix = checkFormat(playerSuffix);
        this.playerFactionTitle = checkFormat(playerFactionTitle);
        this.playerFactionRank = checkFormat(playerFactionRank);
        this.FacitonName = checkFormat(FacitonName);
        this.otherFactionName = checkFormat(otherFactionName);
    }

    public FactionChatMessage(String format, String message, boolean allowCostomColour) {
        this.format = checkFormat(format);
        this.message = checkFormat(message);
        this.allowCostomColour = allowCostomColour;
        this.playerPrefix = null;
        this.playerName = null;
        this.playerSuffix = null;
        this.playerFactionTitle = null;
        this.playerFactionRank = null;
        this.FacitonName = null;
        this.otherFactionName = null;
    }

    @Override
    public String toString() {
        String output;
        if (allowCostomColour) {
            message = message.replaceAll("/&", "/and");
            message = message.replaceAll("&", "" + (char) 167);
            message = message.replaceAll("/and", "&");
        }

        output = message;
        if (format != null) {
            format = format.replaceAll("/&", "/and");
            format = format.replaceAll("&", "" + (char) 167);
            format = format.replaceAll("/and", "&");
            if (playerName != null) {
                format = format.replaceAll("%PLAYER%", playerName);
            }

            if (playerPrefix != null) {
                format = format.replaceAll("%PREFIX%", playerPrefix);
            }
            if (playerSuffix != null) {
                format = format.replaceAll("%SUFFIX%", playerSuffix);
            }
            if (playerFactionTitle != null) {
                format = format.replaceAll("%TITLE%", playerFactionTitle);
            }
            if (playerFactionRank != null) {
                format = format.replaceAll("%FACTIONRANK%", playerFactionRank);
            }
            if (FacitonName != null) {
                format = format.replaceAll("%FACTION%", FacitonName);
            }
            if (otherFactionName != null) {
                format = format.replaceAll("%OTHERFACTION%", otherFactionName);
            }
            
            format = format.replaceAll("  ", " "); //removing double spaces
            message = message.replaceAll("\\$", "\\\\\\$");
            format = format.replaceAll("%MESSAGE%", message);

            output = format;
        }

        return output;
    }
    
    private static String checkFormat(String y)
    {
        if (y == null || y.length() == 0)
        {
            return y;
        }
        String output;
        output = y.replaceAll("\\$", "\\\\\\$");
        return output;
    }

}
