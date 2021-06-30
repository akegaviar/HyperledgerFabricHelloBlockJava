
package com.hyperledger.fabric.helloBlock;

import java.util.Objects;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.annotation.JsonProperty;

@DataType()
public final class Hello {

    @Property()
    private final String block;

    public String getBlock() {
        return block;
    }

    public Hello(@JsonProperty("block") final String block) {
        this.block = block;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Hello other = (Hello) obj;

        return Objects.deepEquals(new String[] {getBlock()},
                new String[] {other.getBlock()});
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBlock());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " [block=" + block +"]";
    }
}
