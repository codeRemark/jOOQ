/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.jooq;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A record type for {@link Table}, {@link Cursor}, {@link Result} and other
 * objects.
 * <p>
 * This type differs from {@link Row} in several ways:
 * <ul>
 * <li>It is generic using <code>&lt;R&gt;</code></li>
 * <li>It is not repeated for degrees 1 to 22, such as {@link Row1} ..
 * {@link RowN}</li>
 * <li>It is not part of the DSL</li>
 * </ul>
 *
 * @author Lukas Eder
 */
public interface RecordType<R extends Record> {

    /**
     * Get the degree of this record type.
     */
    int size();

    /**
     * Get a specific field from this record type.
     * <p>
     * This will return:
     * <ul>
     * <li>A field that is the same as the argument field (by identity
     * comparison).</li>
     * <li>A field that is equal to the argument field (exact matching fully
     * qualified name).</li>
     * <li>A field that is equal to the argument field (partially matching
     * qualified name).</li>
     * <li>A field whose name is equal to the name of the argument field.</li>
     * <li><code>null</code> otherwise.
     * </ul>
     * If several fields have the same name, the first one is returned and a
     * warning is logged.
     *
     * @param <T> The generic field type
     * @param field The field to fetch
     * @return The field itself or an aliased field
     */
    @Nullable
    <T> Field<T> field(Field<T> field);

    /**
     * Get a specific field from this record type.
     *
     * @param fieldName The field to fetch
     * @return The field with the given name
     */
    @Nullable
    Field<?> field(String fieldName);

    /**
     * Get a specific field from this record type coerced to <code>type</code>.
     *
     * @param fieldName The field to fetch
     * @param type The type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(String fieldName, Class<T> type);

    /**
     * Get a specific field from this record type coerced to <code>dataType</code>.
     *
     * @param fieldName The field to fetch
     * @param dataType The data type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(String fieldName, DataType<T> dataType);

    /**
     * Get a specific qualified field from this record type.
     *
     * @param fieldName The field to fetch
     * @return The field with the given name
     */
    @Nullable
    Field<?> field(Name fieldName);

    /**
     * Get a specific field from this record type coerced to <code>type</code>.
     *
     * @param fieldName The field to fetch
     * @param type The type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(Name fieldName, Class<T> type);

    /**
     * Get a specific field from this record type coerced to <code>dataType</code>.
     *
     * @param fieldName The field to fetch
     * @param dataType The data type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(Name fieldName, DataType<T> dataType);

    /**
     * Get a specific field from this record type.
     *
     * @param fieldIndex The field's index of the field to fetch
     * @return The field with the given name
     */
    @Nullable
    Field<?> field(int fieldIndex);

    /**
     * Get a specific field from this record type coerced to <code>type</code>.
     *
     * @param fieldIndex The field's index of the field to fetch
     * @param type The type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(int fieldIndex, Class<T> type);

    /**
     * Get a specific field from this record type coerced to <code>dataType</code>.
     *
     * @param fieldIndex The field's index of the field to fetch
     * @param dataType The data type to coerce the resulting field to
     * @return The field with the given name
     */
    @Nullable
    <T> Field<T> field(int fieldIndex, DataType<T> dataType);

    /**
     * Get all fields from this record type.
     *
     * @return All available fields
     */
    @NotNull
    Field<?>[] fields();

    /**
     * Get all fields from this record type, providing some fields.
     *
     * @return All available fields
     * @see #field(Field)
     */
    @NotNull
    Field<?>[] fields(Field<?>... fields);

    /**
     * Get all fields from this record type, providing some field names.
     *
     * @return All available fields
     * @see #field(String)
     */
    @NotNull
    Field<?>[] fields(String... fieldNames);

    /**
     * Get all fields from this record type, providing some field names.
     *
     * @return All available fields
     * @see #field(Name)
     */
    @NotNull
    Field<?>[] fields(Name... fieldNames);

    /**
     * Get all fields from this record type, providing some field indexes.
     *
     * @return All available fields
     * @see #field(int)
     */
    @NotNull
    Field<?>[] fields(int... fieldIndexes);

    /**
     * Get a field's index from this record type.
     *
     * @param field The field to look for
     * @return The field's index or <code>-1</code> if the field is not
     *         contained in this <code>Row</code>
     */
    int indexOf(Field<?> field);

    /**
     * Get a field's index from this record type.
     *
     * @param fieldName The field name to look for
     * @return The field's index or <code>-1</code> if the field is not
     *         contained in this <code>Row</code>
     */
    int indexOf(String fieldName);

    /**
     * Get a field's index from this record type.
     *
     * @param fieldName The field name to look for
     * @return The field's index or <code>-1</code> if the field is not
     *         contained in this <code>Row</code>
     */
    int indexOf(Name fieldName);

    /**
     * Get an array of types for this record type.
     * <p>
     * Entries in the resulting array correspond to {@link Field#getType()} for
     * the corresponding <code>Field</code> in {@link #fields()}
     */
    @NotNull
    Class<?>[] types();

    /**
     * Get the type for a given field index.
     *
     * @param fieldIndex The field's index of the field's type to fetch
     * @return The field's type
     */
    @Nullable
    Class<?> type(int fieldIndex);

    /**
     * Get the type for a given field name.
     *
     * @param fieldName The field's name of the field's type to fetch
     * @return The field's type
     */
    @Nullable
    Class<?> type(String fieldName);

    /**
     * Get the type for a given field name.
     *
     * @param fieldName The field's name of the field's type to fetch
     * @return The field's type
     */
    @Nullable
    Class<?> type(Name fieldName);

    /**
     * Get an array of data types for this record type.
     * <p>
     * Entries in the resulting array correspond to {@link Field#getDataType()}
     * for the corresponding <code>Field</code> in {@link #fields()}
     */
    @NotNull
    DataType<?>[] dataTypes();

    /**
     * Get the data type for a given field index.
     *
     * @param fieldIndex The field's index of the field's data type to fetch
     * @return The field's data type
     */
    @Nullable
    DataType<?> dataType(int fieldIndex);

    /**
     * Get the data type for a given field name.
     *
     * @param fieldName The field's name of the field's data type to fetch
     * @return The field's data type
     */
    @Nullable
    DataType<?> dataType(String fieldName);

    /**
     * Get the data type for a given field name.
     *
     * @param fieldName The field's name of the field's data type to fetch
     * @return The field's data type
     */
    @Nullable
    DataType<?> dataType(Name fieldName);

}
