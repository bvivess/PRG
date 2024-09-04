package ACT10_0H;

// Definici� de l'enum OperacioMatematica
public enum OperacioMatematica {
    // Enum constantes con implementaciones espec�ficas
    SUMA {
        @Override
        public double executa(double x, double y) {
            return x + y;
        }

        @Override
        public String toString() {
            return "Suma";
        }
    },
    RESTA {
        @Override
        public double executa(double x, double y) {
            return x - y;
        }

        @Override
        public String toString() {
            return "Resta";
        }
    },
    MULTIPLICACIO {
        @Override
        public double executa(double x, double y) {
            return x * y;
        }

        @Override
        public String toString() {
            return "Multiplicaci�";
        }
    },
    DIVISIO {
        @Override
        public double executa(double x, double y) {
            if (y != 0) {
                return x / y;
            } else {
                throw new ArithmeticException("No es possible dividir per zero");
            }
        }

        @Override
        public String toString() {
            return "Divisi�";
        }
    };

    // M�todo abstracto que cada constante debe implementar
    public abstract double executa(double x, double y);
}