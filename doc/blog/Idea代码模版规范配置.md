# Idea代码模版规范配置



其中$params$ 、$returns$ 变量是由groovy script 脚本处理

params :

```groovy
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); def paramsType=\"${_2}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); if (''.equals(params.get(0))) {return '';}; for(i = 0; i < params.size(); i++) {result+= (i > 0 ? ' * @param ':' @param ') + params[i] +((i < params.size() - 1) ? ' {@link '+paramsType[i]+'}\\n' : ' {@link ' + paramsType[i]) + '}'}; return result", methodParameters(),methodParameterTypes())
```



returns:

```groovy
groovyScript("def returnV = \"${_1}\".toString();return 'void'.equals(returnV) ? '':' @return {@link ' + returnV + '}';",methodReturnType())
```

