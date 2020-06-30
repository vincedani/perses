/*
 * Copyright (C) 2018-2020 University of Waterloo.
 *
 * This file is part of Perses.
 *
 * Perses is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3, or (at your option) any later version.
 *
 * Perses is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Perses; see the file LICENSE.  If not see <http://www.gnu.org/licenses/>.
 */
package org.perses.antlr.pnf;

import org.perses.antlr.RuleType;
import org.perses.antlr.ast.AstTag;

public final class PnfUtil {

  public static RuleType getRuleTypeIfQuantifiedOrThrow(AstTag tag) {
    switch (tag) {
      case STAR:
        return RuleType.KLEENE_STAR;
      case OPTIONAL:
        return RuleType.OPTIONAL;
      case PLUS:
        return RuleType.KLEENE_PLUS;
    }
    throw new RuntimeException("Unhandled tag " + tag);
  }
}
