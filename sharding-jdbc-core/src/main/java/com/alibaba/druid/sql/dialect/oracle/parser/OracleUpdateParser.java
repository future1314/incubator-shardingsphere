/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.druid.sql.dialect.oracle.parser;

import com.alibaba.druid.sql.lexer.Token;
import com.alibaba.druid.sql.parser.AbstractUpdateParser;
import com.alibaba.druid.sql.parser.SQLExprParser;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OracleUpdateParser extends AbstractUpdateParser {
    
    public OracleUpdateParser(final ShardingRule shardingRule, final List<Object> parameters, final SQLExprParser exprParser) {
        super(shardingRule, parameters, exprParser);
    }
    
    @Override
    protected void parseBetweenUpdateAndTable() {
        getExprParser().parseHints();
    }
    
    @Override
    protected Set<String> getIdentifiersBetweenUpdateAndTable() {
        Set<String> result = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        result.add(Token.ONLY.getName());
        return result;
    }
}
