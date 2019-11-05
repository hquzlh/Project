package flyweight;

import java.util.HashMap;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 10:30
 **/

//享元工厂
public class FlyWeightFactory {
    private HashMap<String, FlyWeight> flyWeights = new HashMap<String, FlyWeight>();
public FlyWeight getFlyWeight(String key) {
 if (!flyWeights.containsKey(key)) {
flyWeights.put(key, new ConcreteFlyWeight());
 }
 return flyWeights.get(key);
 }
}
