/*
 * This file is part of HuskTowns by William278. Do not redistribute!
 *
 *  Copyright (c) William278 <will27528@gmail.com>
 *  All rights reserved.
 *
 *  This source code is provided as reference to licensed individuals that have purchased the HuskTowns
 *  plugin once from any of the official sources it is provided. The availability of this code does
 *  not grant you the rights to modify, re-distribute, compile or redistribute this source code or
 *  "plugin" outside this intended purpose. This license does not cover libraries developed by third
 *  parties that are utilised in the plugin.
 */

    package net.william278.husktowns.user;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;
    import net.william278.husktowns.claim.Position;
    import org.jetbrains.annotations.NotNull;
    import org.jetbrains.annotations.Nullable;

    import java.util.HashSet;
    import java.util.Optional;
    import java.util.Set;

    /**
     * Represents a user's preferences
     *
     * @since 2.0
     */
    public class Preferences {

        @Expose
        @SerializedName("town_chat_talking")
        private boolean townChatTalking;

        @Expose
        @SerializedName("town_chat_spying")
        private boolean townChatSpying;

        @Expose
        @SerializedName("town_notifications")
        private boolean townMessages;

        @Expose
        @SerializedName("auto_claiming_land")
        private boolean autoClaimingLand;

        @Expose
        @SerializedName("ignoring_claims")
        private boolean ignoringClaims;

        @Expose
        @SerializedName("teleport_target")
        @Nullable
        private Position teleportTarget;

        @Expose
        @SerializedName("completed_advancements")
        @Nullable
        private Set<String> completedAdvancements;

        /**
         * Get the default user {@link Preferences}
         *
         * @return The default {@link Preferences}
         * @since 2.0
         */
        @NotNull
        public static Preferences getDefaults() {
            return new Preferences(false, false, true, false, false);
        }

        /**
         * <b>Internal use only</b> - Construct {@link Preferences} for a user
         *
         * @param townChatTalking  If the user is talking in town chat
         * @param townChatSpying   If the user is spying on town chat
         * @param townMessages     If the user is receiving town notifications
         * @param autoClaimingLand If the user is auto-claiming land
         * @param ignoringClaims   If the user is ignoring claims
         * @since 2.0
         */
        private Preferences(boolean townChatTalking, boolean townChatSpying, boolean townMessages,
                            boolean autoClaimingLand, boolean ignoringClaims) {
            this.townChatTalking = townChatTalking;
            this.townChatSpying = townChatSpying;
            this.townMessages = townMessages;
            this.autoClaimingLand = autoClaimingLand;
            this.ignoringClaims = ignoringClaims;
        }

        @SuppressWarnings("unused")
        private Preferences() {
        }

        /**
         * Get if the user is talking in town chat
         *
         * @return {@code true} if the user is talking in town chat, {@code false} otherwise
         * @since 2.0
         */
        public boolean isTownChatTalking() {
            return townChatTalking;
        }

        /**
         * Set if the user is talking in town chat
         *
         * @param townChatTalking {@code true} if the user is talking in town chat, {@code false} otherwise
         * @since 2.0
         */
        public void setTownChatTalking(boolean townChatTalking) {
            this.townChatTalking = townChatTalking;
        }

        /**
         * Get if the user is spying on town chat
         *
         * @return {@code true} if the user is spying on town chat, {@code false} otherwise
         * @since 2.0
         */
        public boolean isTownChatSpying() {
            return townChatSpying;
        }

        /**
         * Set if the user is spying on town chat
         *
         * @param townChatSpying {@code true} if the user is spying on town chat, {@code false} otherwise
         * @since 2.0
         */
        public void setTownChatSpying(boolean townChatSpying) {
            this.townChatSpying = townChatSpying;
        }

        /**
         * Get if the user is receiving town notifications and chat messages
         *
         * @return {@code true} if the user is receiving town notifications, {@code false} otherwise
         * @since 2.0
         * @deprecated Use {@link #sendTownMessages()} instead
         */
        @Deprecated(since = "2.4")
        public boolean isTownMessages() {
            return sendTownMessages();
        }

        /**
         * Get if the user is receiving town notifications and chat messages
         *
         * @return {@code true} if the user is receiving town notifications, {@code false} otherwise
         * @since 2.0
         */
        public boolean sendTownMessages() {
            return townMessages;
        }

        /**
         * Set if the user is receiving town notifications and chat messages
         *
         * @param townMessages {@code true} if the user is receiving town notifications, {@code false} otherwise
         * @since 2.0
         * @deprecated Use {@link #setSendTownMessages(boolean)} instead
         */
        @Deprecated(since = "2.4")
        public void setTownMessages(boolean townMessages) {
            setSendTownMessages(townMessages);
        }

        /**
         * Set if the user is receiving town notifications and chat messages
         *
         * @param townNotifications {@code true} if the user is receiving town notifications, {@code false} otherwise
         * @since 2.4
         */
        public void setSendTownMessages(boolean townNotifications) {
            this.townMessages = townNotifications;
        }

        /**
         * Get if the user is auto-claiming land
         *
         * @return {@code true} if the user is auto-claiming land, {@code false} otherwise
         * @since 2.0
         */
        public boolean isAutoClaimingLand() {
            return autoClaimingLand;
        }

        /**
         * Set if the user is auto-claiming land
         *
         * @param autoClaimingLand {@code true} if the user is auto-claiming land, {@code false} otherwise
         * @since 2.0
         */
        public void setAutoClaimingLand(boolean autoClaimingLand) {
            this.autoClaimingLand = autoClaimingLand;
        }

        /**
         * Get if the user is ignoring claims
         *
         * @return {@code true} if the user is ignoring claims, {@code false} otherwise
         * @since 2.0
         */
        public boolean isIgnoringClaims() {
            return ignoringClaims;
        }

        /**
         * Set if the user is ignoring claims
         *
         * @param ignoringClaims {@code true} if the user is ignoring claims, {@code false} otherwise
         * @since 2.0
         */
        public void setIgnoringClaims(boolean ignoringClaims) {
            this.ignoringClaims = ignoringClaims;
        }

        /**
         * <b>Internal use only</b> - Get the user's current teleport target. This is used for cross-server teleportation.
         *
         * @return The current teleport target, if the user has one.
         * @since 2.0
         */
        public Optional<Position> getTeleportTarget() {
            return Optional.ofNullable(teleportTarget);
        }

        /**
         * <b>Internal use only</b> - Set the user's current teleport target. This is used for cross-server teleportation.
         *
         * @param target The teleport target
         * @since 2.0
         */
        public void setTeleportTarget(@NotNull Position target) {
            this.teleportTarget = target;
        }

        /**
         * <b>Internal use only</b> - Clear the user's current teleport target. This is used for cross-server teleportation.
         *
         * @since 2.0
         */
        public void clearTeleportTarget() {
            this.teleportTarget = null;
        }

        @NotNull
        public Set<String> getCompletedAdvancements() {
            return Optional.ofNullable(completedAdvancements).orElse(new HashSet<>());
        }

        public boolean isCompletedAdvancement(@NotNull String advancementKey) {
            return Optional.ofNullable(completedAdvancements).orElse(Set.of()).contains(advancementKey);
        }

        public void addCompletedAdvancement(@NotNull String advancementKey) {
            if (completedAdvancements == null) {
                completedAdvancements = new HashSet<>();
            }
            completedAdvancements.add(advancementKey);
        }

        public void resetAdvancements() {
            completedAdvancements = null;
        }
    }
