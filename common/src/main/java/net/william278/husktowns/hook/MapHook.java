package net.william278.husktowns.hook;

import net.william278.husktowns.HuskTowns;
import net.william278.husktowns.claim.TownClaim;
import net.william278.husktowns.claim.World;
import net.william278.husktowns.town.Town;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class MapHook extends Hook {

    protected MapHook(@NotNull HuskTowns plugin, @NotNull String name) {
        super(plugin, name);
    }

    public abstract void setClaimMarker(@NotNull TownClaim claim, @NotNull World world);

    public abstract void removeClaimMarker(@NotNull TownClaim claim, @NotNull World world);

    public final void removeClaimMarkers(@NotNull Town town) {
        plugin.getWorlds().forEach(world -> plugin.getClaimWorld(world).ifPresent(claimWorld -> {
            final List<TownClaim> claims = claimWorld.getClaims()
                    .getOrDefault(town.getId(), new ConcurrentLinkedQueue<>()).stream()
                    .map(claim -> new TownClaim(town, claim)).toList();
            removeClaimMarkers(claims, world);
        }));
    }

    public abstract void setClaimMarkers(@NotNull List<TownClaim> claims, @NotNull World world);

    public final void setClaimMarkers(@NotNull Town town) {
        plugin.getWorlds().forEach(world -> plugin.getClaimWorld(world).ifPresent(claimWorld -> {
            final List<TownClaim> claims = claimWorld.getClaims()
                    .getOrDefault(town.getId(), new ConcurrentLinkedQueue<>()).stream()
                    .map(claim -> new TownClaim(town, claim)).toList();
            setClaimMarkers(claims, world);
        }));
    }

    public abstract void removeClaimMarkers(@NotNull List<TownClaim> claims, @NotNull World world);

    public final void reloadClaimMarkers(@NotNull Town town) {
        this.removeClaimMarkers(town);
        this.setClaimMarkers(town);
    }

    public abstract void clearAllMarkers();

    @NotNull
    protected final String getMarkerSetKey() {
        return plugin.getKey(getName().toLowerCase(), "markers").toString();
    }

}
