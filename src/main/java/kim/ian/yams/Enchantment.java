package kim.ian.yams;

import kim.ian.yams.enums.EnchantmentSubtype;

import java.util.Set;

public interface Enchantment {
    public Set<EnchantmentSubtype> getSubtypes();
}
