package org.example.a.creation.c.builder;

/**
 * @author goku
 * @datetime 2023/8/2 9:39 PM
 */
public class ConstructorArgs {
    private boolean isRef;
    private Class type;
    private Object arg;
    // TODO: 待完善...

    public ConstructorArgs(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArgs build() {
            if (!isRef && (type == null || arg == null)) {
                throw new IllegalArgumentException("...");
            }
            return new ConstructorArgs(this);
            }
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }

        public void setType(Class type) {
            this.type = type;
        }
    }
}
